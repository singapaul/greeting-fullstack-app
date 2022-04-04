import { useEffect } from "react";
import "./App.css";

const App = () => {
  const getGreetings = async () => {
    const response = await fetch("http://localhost:8080/greetings");
    const greetingsArray = await response.json();

    console.log(greetingsArray);
  };

  useEffect(() => {
    getGreetings();
  }, []);

  return <h1>Hello there</h1>;
};

export default App;