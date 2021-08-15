import React from 'react';
// import PropTypes from 'prop-types';
import styles from './HomePage.module.scss';
import { CountryProvider } from '../../context/CountryContext';
import CountryPicker from '../CountryPicker/CountryPicker';
import CountryDetails from '../CountryDetails/CountryDetails';

const HomePage = () => {
  console.log("homePAGE");
  return (
    <div className={styles.HomePage}>
      <CountryProvider defaultCountry="BR">
        <CountryPicker></CountryPicker>
        <hr />
        <CountryDetails></CountryDetails>
      </CountryProvider>
      <div className={`${styles.random} `}>RANDOM</div>
    </div>
  );
};

HomePage.propTypes = {};

HomePage.defaultProps = {};

export default HomePage;
