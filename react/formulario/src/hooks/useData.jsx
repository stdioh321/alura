import { useState } from "react";

function useData() {
  const [data, setData] = useState(null);

  function setField(fName, val, validations = null) {
    let newData = { ...data };
    let errors = [];
    if (validations) {
      if (!Array.isArray(validations)) validations = [validations];
      validations.forEach((item1, idx1) => {
        let resultValidation = item1(val);
        if (resultValidation) errors.push(resultValidation);
      });
    }
    newData[fName] = { value: val, errors: errors.length < 1 ? null : errors };
    setData(newData);
  }

  return [data, setField];
}

export default useData;

export class DataWithValidation {
  _data = {};

  setData(field, value, validators = null) {
    if (!field) return;
    this._data[field] = { value: value, errors: null };
    if (!validators) return;
    this.setValidators(
      field,
      Array.isArray(validators) ? validators : [validators]
    );
  }
  getData() {
    return this._data;
  }

  setValidators(field, validators) {
    if (!(field in this._data)) return;
    let currentField = this._data[field];
    currentField.validators = [...validators];
  }

  validate() {
    let isValid = true;
    Object.keys(this._data).forEach((it1, idx1) => {
      let currentField = this._data[it1];
      currentField.errors = [];
      for (let validation in currentField.validators) {
        currentField.errors.push(currentField.validators[validation]());
        isValid = false;
      }
      if (currentField.errors.length < 1) currentField.errors = null;
    });
    return isValid;
  }
}

class CommonData {
  field = null;
  value = null;
  validators = [];
  errors = null;

  constructor(field, value) {
    this.field = field;
    this.value = value;
  }
}
