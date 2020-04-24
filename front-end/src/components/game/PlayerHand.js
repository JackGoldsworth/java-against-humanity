import React from 'react'
import WhiteCard from "./WhiteCard";

const PlayerHand = () => {
        return(
            <div className={'wholeThing'}>
                <div className={'playerHand'}>
                <WhiteCard label = {'1'}/>
                <WhiteCard label = {'2'}/>
                <WhiteCard label = {'3'}/>
                <WhiteCard label = {'4'}/>
                <WhiteCard label = {'5'}/>
                <WhiteCard label = {'6'}/>
                <WhiteCard label = {'7'}/>
                </div>
            </div>
        );
}
export default PlayerHand;