import React, { useState, useEffect } from "react";
import "../assets/css/componentes/Loading.css";

function Loading({ children }) {
  const [dots, setDots] = useState("");
  useEffect(() => {
    console.log("dots CHANGED");
    changeDots();
  }, [dots]);

  const changeDots = () => {
    setTimeout(function () {
      //   if (dots.length >= 5) setDots(".");
      //   else setDots(dots + ".");
    }, 300);
  };

  return <div className="Loading">{children ? children : `Loading`}</div>;
}

export default Loading;
