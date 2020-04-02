import React from 'react';
import PlayerHand from "./components/PlayerHand";
import ScoreName from "./components/ScoreName";
import BlackCard from "./components/BlackCard";


class SelectCard extends React.Component{

    render()
    {
        return (
            <div className={'wholeThing'}>

                <div className={'players'}>
                    <ScoreName label = {'Josh Edwards'} value = {0}/>
                    <ScoreName label = {'Owen Snyder'} value = {0}/>
                    <ScoreName label = {'Jack Goldsomething'} value = {-1}/>
                    <ScoreName label = {'Will Hunt'} value = {0}/>
                </div>

                <div className={'cards'}>
                <BlackCard label = {'Hillary Clinton is _____ when Bill gets home.'}/>
                <PlayerHand />
                </div>

            </div>
        );
    }
}

export default SelectCard;

