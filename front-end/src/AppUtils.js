// https://stackoverflow.com/questions/10730362/get-cookie-by-name
// This exists to get the proper cookie from the cookie set.

export const getUsername = () => {
    let value = "; " + document.cookie;
    let parts = value.split("; username=");
    if (parts.length === 2) {
        return parts.pop().split(";").shift().toString();
    }
}

export const getPartyId = () => {
    let value = "; " + document.cookie;
    let parts = value.split("; joinCode=");
    if (parts.length === 2) {
        return parts.pop().split(";").shift();
    }
}