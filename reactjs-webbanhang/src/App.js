import React, {useState, useEffect} from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';

const Product = () => {
    const fetchProduct = () => {
        axios.get("http://localhost:8080/product").then(res => {
            console.log(res);
        });

    }

    useEffect(() => {
        fetchProduct()
    }, []);

    return <h1>Hello</h1>;

}

function App() {
    return (
        <div className="App">
            <Product />
        </div>
    );
}

export default App;
