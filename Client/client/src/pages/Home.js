import React from 'react';
import { BodyContainer } from '../components/BodyContainer';
import QuestionHeader from '../components/QuestionHeader';
import QuestionContainer from '../components/QuestionContainer';

const Home = () => {
    return (
        <BodyContainer>
            <QuestionHeader />
            <QuestionContainer />
        </BodyContainer>
    );
};

export default Home;
