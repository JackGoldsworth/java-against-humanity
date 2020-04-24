import React from 'react';
import ScoreName from "./ScoreName";
import BlackCard from "./BlackCard";
import WhiteCard from "./WhiteCard";


class CzarView extends React.Component {

    render() {
        return (
            <section className="hero is-fullheight is-mobile has-background-dark has-text-white">
                <div class="level">

                </div>
                <div class="level">
                    <div className="level-right">
                        <button className="button "> Back</button>
                    </div>
                    <div className="level-item">
                        <h1>Cards Against Humanity Clone</h1>
                    </div>
                    <div className="level-left">
                        YOU ARE THE CZAR!
                    </div>
                </div>

                <div class="level">
                    <div className="level-item">
                        <ScoreName label={"Big Jed"} value={0}/>
                    </div>

                    <div className="level-item">
                        <ScoreName label={"Owen Boi"} value={0}/>
                    </div>

                    <div className="level-item">
                        <ScoreName label={"Jack Nerd"} value={0}/>
                    </div>

                    <div className="level-item">
                        <ScoreName label={"Jeff Epstein"} value={0}/>
                    </div>
                </div>

                <div className="level">
                    <div className="level-item">
                        <BlackCard label="BLACK CARD TO BE FILLED WITH SILLY PROMPT"/>
                    </div>
                </div>

                <div class="level">
                    Your cards:
                    <div className="level-item">
                        <WhiteCard label="WHITE CARD FROM ONE OF THE PLAYERS"/>
                    </div>
                    <div className="level-item">
                        <WhiteCard label="WHITE CARD FROM ONE OF THE PLAYERS"/>
                    </div>
                    <div className="level-item">
                        <WhiteCard label="WHITE CARD FROM ONE OF THE PLAYERS"/>
                    </div>
                    <div className="level-item">
                        <WhiteCard label="WHITE CARD FROM ONE OF THE PLAYERS"/>
                    </div>

                </div>
                <div className="level">
                    <div className="level-item">
                        <WhiteCard label="WHITE CARD FROM ONE OF THE PLAYERS"/>
                    </div>
                    <div className="level-item">
                        <WhiteCard label="WHITE CARD FROM ONE OF THE PLAYERS"/>
                    </div>
                    <div className="level-item">
                        <WhiteCard label="WHITE CARD FROM ONE OF THE PLAYERS"/>
                    </div>
                </div>

                <div className="level">

                </div>

            </section>
        );
    }
}

export default CzarView;

