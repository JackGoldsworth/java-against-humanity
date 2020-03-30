import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import Input from '@material-ui/core/Input';

const useStyles = makeStyles(theme => ({
    toolbar: theme.mixins.toolbar,
    title: {
        flexGrow: 1,
        backgroundColor: theme.palette.background.default,
        padding: theme.spacing(3),
    },
    information: {
        flexGrow: 1,
        padding: theme.spacing(3),
    },
    fullWidth: {
        width: '100%',
    },
}));

function Login() {
    const classes = useStyles;

    return (
        <main className={classes.fullWidth}>
            <div className={classes.toolbar} />
            <div className={classes.title}>
                <Typography variant='h6'>Login</Typography>
            </div>
            <div className={classes.content}>
                <form className={classes.information} noValidate autoComplete='off'>
                    <Input placeholder="nickname" inputProps={{ 'aria-label': 'description' }} />
                    <Button variant='outlined'>Join Game</Button>
                    <Button variant='outlined'>Join Game</Button>
                </form>
            </div>
        </main>
    );
}

export default Login;



