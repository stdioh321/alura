import React, { useContext } from 'react';
import PropTypes from 'prop-types';
import styles from './CountryDetails.module.scss';
import CountryContext from '../../context/CountryContext';

const CountryDetails = () => {
  const {country} = useContext(CountryContext);
  return (
    <div >
      Country: {country ? country : "No country selected."}
    </div>
  );
}

CountryDetails.propTypes = {};

CountryDetails.defaultProps = {};

export default CountryDetails;
