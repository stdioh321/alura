import React from 'react';
import ReactDOM from 'react-dom';
import CountryPicker from './CountryPicker';

it('It should mount', () => {
  const div = document.createElement('div');
  ReactDOM.render(<CountryPicker />, div);
  ReactDOM.unmountComponentAtNode(div);
});