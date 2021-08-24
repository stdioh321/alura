export const themes = {
  default: {
    cor1: "red",
    cor2: "blue",
    body: "green",
  },
  dark: {
    cor1: "black",
    cor2: "grey",
    body: "pink",
  },
};

export const variables = {
  borderSize: "1px",
};

const Theme = (theme = null, useLocalStorage = true) => {
  if (!theme && useLocalStorage) theme = localStorage.getItem("theme");
  return themes[theme] || themes["default"];
};

export default Theme;
