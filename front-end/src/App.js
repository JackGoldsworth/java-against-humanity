import React, {Component} from 'react';
import Home from './components/misc/Home'
import {About} from "./components/misc/About";
import {HostView} from "./components/auth/HostView";
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import {JoinParty} from "./components/auth/JoinParty";
import PlayerMenu from "./components/game/PlayerMenu";

class App extends Component {

    render() {
        return (
            <BrowserRouter>
                <Switch>
                    <Route exact path="/" component={Home}/>
                    <Route exact path="/about" component={About}/>
                    <Route exact path="/hostview" component={HostView}/>
                    <Route exact path="/join" component={JoinParty}/>
                    <Route exact path="/playerMenu" component={PlayerMenu}/>
                </Switch>
            </BrowserRouter>
        )
    }
}

export default App;

