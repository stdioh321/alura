import React,{createContext, useContext, useState} from 'react';

const CountryContext = createContext();

export function CountryProvider({children, defaultCountry=null}){
    const [country,setCountry] = useState(defaultCountry);
    return (
        <CountryContext.Provider value={{country,setCountry}}>{children}</CountryContext.Provider>
    );
}

export default CountryContext