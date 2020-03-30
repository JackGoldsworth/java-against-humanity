import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import * as serviceWorker from './serviceWorker';
import SelectCard from "./SelectCard";

ReactDOM.render(<App/>, document.getElementById('react'));

serviceWorker.unregister();
