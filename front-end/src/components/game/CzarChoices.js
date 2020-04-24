import React from 'react'
import WhiteCard from "./WhiteCard";

const axios = require('axios').default;

const CzarChoices = () => {
        return (
            <div className={'CzarChoices'}>
                <WhiteCard label = {'FIRST CARD FROM PLAYER'}/>
                <WhiteCard label = {'SECOND CARD FROM PLAYER'}/>
                <WhiteCard label = {'THIRD CARD FROM PLAYER'}/>
                <WhiteCard label = {'FOURTH CARD FROM PLAYER'}/>
                <WhiteCard label = {'FIFTH CARD FROM PLAYER'}/>
                <WhiteCard label = {'SIXTH CARD FROM PLAYER'}/>
            </div>
        );
}

export default CzarChoices;