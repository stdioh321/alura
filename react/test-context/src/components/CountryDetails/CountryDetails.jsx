import React, { useContext } from "react";
import PropTypes from "prop-types";
import styles from "./CountryDetails.module.scss";
import CountryContext from "../../context/CountryContext";
import { QueryClient, QueryClientProvider, useQuery } from "react-query";

async function fetchUsers(tmp) {
  try {
    const response = await fetch(
      `https://restcountries.eu/rest/v2/alpha/${tmp.queryKey[0]}`
    );
    const data = await response.json();

    return data;
  } catch (error) {
    console.log("ERROR:");
    console.log(error);
    throw new error();
  }
}

function TheComponent() {
  const { country } = useContext(CountryContext);
  const { isLoading, error, data } = useQuery([country], fetchUsers);
  if (error)
    return (
      <div>
        <div>Ooops!! Some error.</div>
        <div>Look the console</div>
      </div>
    );
  if (isLoading) return <div>Loading...</div>;

  return (
    <div>
      <div>Country: {country ? country : "No country selected."}</div>
      <br />
      <div style={{ "font-weight": "900", "font-size": "1.3em" }}>
        URL:{" "}
        <a
          target="_blank"
          href={`https://restcountries.eu/rest/v2/alpha/${country}`}
        >
          https://restcountries.eu/rest/v2/alpha/{country}
        </a>
      </div>
      <pre
        style={{
          border: "solid red 1px",
          padding: "15px",
          "max-height": "300px",
          overflow: "auto",
        }}
      >
        {JSON.stringify(data, null, 2)}
      </pre>
    </div>
  );
}

CountryDetails.propTypes = {};

CountryDetails.defaultProps = {};

const queryClient = new QueryClient();

export default function CountryDetails() {
  return (
    <QueryClientProvider client={queryClient}>
      <TheComponent />
    </QueryClientProvider>
  );
}

// import React, { Component, useContext } from 'react';
// import CountryContext from '../../context/CountryContext';
// class CountryDetails extends Component {

//   constructor(){
//      super();

//   }
//   render() {
//     return (
//       <div>Country Details</div>
//     );
//   }
// }

// export default CountryDetails;
