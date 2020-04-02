import React from 'react';
import PlayerHand from "./components/PlayerHand";
import ScoreName from "./components/ScoreName";
import BlackCard from "./components/BlackCard";
import CzarChoices from "./components/CzarChoices";


class CzarView extends React.Component{

    render()
    {
        return (
            <div className={'wholeCzarView'}>

                <div className={'players'}>
                    <ScoreName label = {'Josh Edwards'} value = {0}/>
                    <ScoreName label = {'Owen Snyder'} value = {0}/>
                    <ScoreName label = {'Jack Goldsomething'} value = {-1}/>
                    <ScoreName label = {'Will Hunt'} value = {0}/>
                </div>

                <div className={'cards'}>
                    <BlackCard label = {'Hillary Clinton is _____ when Bill gets home.'}/>
                    <CzarChoices />
                </div>

            </div>
        );
    }
}

export default CzarView;

