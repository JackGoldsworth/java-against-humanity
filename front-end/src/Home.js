import React from "react";
import { makeStyles } from '@material-ui/core/styles';
import login from "../front-end/src/components/Login";
import TopBar from "../front-end/src/components/TopBar";

const useStyles = makeStyles(theme => ({
    root: {
        display: 'flex',
    },
}));

function Home() {
    const classes = useStyles();

    return (
        <div className={classes.root}>
            <TopBar/>
            <login/>
        </div>
    );
}

export default Home;
