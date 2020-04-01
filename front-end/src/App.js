import React, {Component} from 'react';
import Home from './components/home/Home'
import {About} from "./components/about/About";
import {BrowserRouter, Route, Switch} from 'react-router-dom';

class App extends Component {

    render() {
        return (
            <BrowserRouter>
                <Switch>
                    <Route exact path="/" component={Home}/>
                    <Route exact path="/about" component={About}/>
                </Switch>
            </BrowserRouter>
        )
    }
}

export default App;

