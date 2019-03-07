import { StringifyOptions } from 'querystring';

export interface ResponseState{
    success: boolean;
    description: string;
}

export interface Review{
    id: number;
    gameId: number;
    gameName: string;
    gameRate: number;
    description?: string;
    author?: string;
}

export interface ReviewList{
    state: ResponseState;
    reviews?: Review[];
    author?: string;
}

export interface Message{
    id: number;
    from: string;
    to: string;
    topic: string;
    text: string;
    date: string;
}

export interface MessageList{
    state: ResponseState;
    messages?: Message[];
}

export interface PersonResponse{
    success: boolean;
    description: string;
    id: number;
    email: string;
    registerDate: string;
    numOfFriends: number;
    numOfGames: number;
    numOfReviews: number;
    name?: string;
    surname?: string;
    country?: string;
    city?: string;
    birthDate: string;
}

export interface Friend{
    friendname: string;
}

export interface FriendResponse{
    state: boolean;
    description: string;
    friends: Friend[];
}



































export interface User{
    j_username: string
    j_password: string
}

export interface NewUser{
    nickname: string 
    email: string
    password: string
}

export interface UserInfo{
  getUserInfo(): any;
    success: boolean
    description: string
    nickname: string
    friends: Array<Friends> 
    games: Array<Games>
    reviews: Array<Reviews>
}

export interface Games{
    gameid: number
    gamename: string
}

export interface Friends{
    friendname: string
    friendurl?: string
}
export interface Reviews{
    gameid: number
    gamename: string
    gamerate: number
}

export interface Game{
    gameid: number
    gamename: string
    gamerate: number
} 
