import React from 'react';
import ReactDOM from 'react-dom';
import CountryDetails from './CountryDetails';

it('It should mount', () => {
  const div = document.createElement('div');
  ReactDOM.render(<CountryDetails />, div);
  ReactDOM.unmountComponentAtNode(div);
});