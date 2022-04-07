import { useEffect, useState } from "react";
import "./App.css";

const App = () => {
  const [greetingValue, setGreetingValue] = useState("Default");

  const url = "http://localhost:8080";
  const fetchString = "/greetings";
  // const getGreetings = async () => {
  //   const response = await fetch(url + fetchString);
  //   const greetingsArray = await response.json();
  //   console.log(greetingsArray);
  //   return greetingsArray;
  // };

  const getRandomGreeting = async () => {
    const response = await fetch("http://localhost:8080/randomGreeting");
    const randomGreeting = await response.text();
    console.log(randomGreeting);
    setGreetingValue(randomGreeting);
  };


  

  useEffect(() => {
    getRandomGreeting();
  }, []);



  return (
    <>
      <h1>Hello there</h1>

      <div>
        <button onClick={getRandomGreeting}>Push for a greeting</button>
        <h2>{greetingValue}</h2>
      </div>
    </>
  );
};

export default App;
