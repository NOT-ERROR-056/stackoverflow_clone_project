import React from 'react';
import { BodyContainer } from '../components/BodyContainer';
import QuestionHeader from '../components/QuestionHeader';
import QuestionContainer from '../components/QuestionContainer';

const Home = ({ setUserInfo }) => {
    return (
        <BodyContainer>
            <QuestionHeader />
            <QuestionContainer setUserInfo={setUserInfo} />
        </BodyContainer>
    );
};

export default Home;
