import React, { useContext } from "react";
import PropTypes from "prop-types";
import styles from "./CountryPicker.module.scss";
import CountryContext from "../../context/CountryContext";

const CountryPicker = () => {
  const countries = [
    { id: "CA", name: "Canada" },
    { id: "BR", name: "Brasil" },
    { id: "PT", name: "Portugal" },
    { id: "JP", name: "Japan" },
  ];
  const { country, setCountry } = useContext(CountryContext);

  return (
    <div>
      Select the Country:&nbsp;
      <select
        value={country}
        onChange={(ev) => {
          const val = ev.target.value;
          if (!val) return;
          setCountry(val);
        }}
      >
        <option value={null} disabled>
          Choose one...
        </option>
        {countries.map((c1, idx1) => {
          return (
            <option key={idx1} value={c1.id}>
              {c1.id} - {c1.name}
            </option>
          );
        })}
      </select>
    </div>
  );
};

CountryPicker.propTypes = {};

CountryPicker.defaultProps = {};

export default CountryPicker;
