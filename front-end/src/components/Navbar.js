import React from 'react'

export class NavBar extends React.Component {

    render() {
        return (
            <nav className="navbar is-dark" role="navigation" aria-label="main navigation">
                <div id="visionNavbar" className="navbar-menu">
                    <div className="navbar-start">
                        <a className="navbar-item has-text-light" href="/">
                            Home
                        </a>
                        <a className="navbar-item has-text-light" href={"/about"}>
                            About
                        </a>
                    </div>
                </div>
            </nav>
        );
    }
}