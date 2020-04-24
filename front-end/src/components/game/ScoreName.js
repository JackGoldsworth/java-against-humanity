import React from 'react'

const ScoreName = (props) => {
        return(
            <div className={'selectCard'}>
                <div className="playerName">
                    <input type="text" readOnly value = {'Name: ' + props.label}/>
                </div>
                <div className="playerScore">
                    <input type="text" readOnly value = {'Score: ' + props.value}/>
                </div>
            </div>
        );
}
export default ScoreName;