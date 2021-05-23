import logo from './logo.svg';
import './App.css';
import React, { Component } from 'react'
class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      count: 0,
      value: ''
    };
  }

  handleChange = (event) => {
    this.setState({value: event.target.value});
    if(event.target.value!==undefined && event.target.value!==''){
    const apiUrl = 'http://localhost:8080/api/v1/getCountOfCities/'+event.target.value;
    fetch(apiUrl)
      .then((response) => response.json())
      .then((data) => {
        console.log('This is your data', data)
        this.setState({count:data.count})
      });
    }
  }

render(){
  return (
    <div className="App">
       <label>
                        <span className="text">Enter a letter and will show the number of cities beginning with that lette : </span>
                        <input value={this.state.value} onChange={this.handleChange} name="text"/>
                        <br/>
      </label>
      <label>
                        <span className="text">Number of cities beginning with that letter is <b>{this.state.count}</b></span>

      </label>
    </div>
  );
}
}

export default App;
