import * as SockJS from 'sockjs-client'
import * as Stomp from 'stompjs'

let stompClient = null;

export const connect = () => {
    let socket = new SockJS('/czar');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/results', function (messageOutput) {
            console.log(messageOutput.body);
        });
    });
}

export const disconnect = () => {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}

export const sendMessage = (message) => {
    stompClient.send("/czar", {}, message);
}