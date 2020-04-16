import React, {Component} from 'react';
import Home from './components/home/Home'
import {About} from "./components/about/About";
import {HostView} from "./components/HostView";
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import {JoinParty} from "./components/JoinParty";
import SelectCard from "./SelectCard";

class App extends Component {

    render() {
        return (
            <BrowserRouter>
                <Switch>
                    <Route exact path="/" component={Home}/>
                    <Route exact path="/about" component={About}/>
                    <Route exact path="/hostview" component={HostView}/>
                    <Route exact path="/join" component={JoinParty}/>
                    <Route exact path="/selectView" component={SelectCard}/>
                </Switch>
            </BrowserRouter>
        )
    }
}

export default App;

