import React, { useState } from 'react';
import { BodyContainer } from '../components/BodyContainer';
import QuestionInfo from '../components/QuestionInfo';
import AnswerInfo from '../components/AnswerInfo';
import AnswerList from '../components/AnswerList';
import '../App.css';
import { useParams } from 'react-router-dom';

const Questions = ({ setUserInfo }) => {
    const { id } = useParams();
    const [isDeleted, setIsDeleted] = useState(false);

    return (
        <BodyContainer>
            <QuestionInfo questionId={id} setIsDeleted={setIsDeleted} setUserInfo={setUserInfo} />
            <AnswerList questionId={id} isDeleted={isDeleted} setIsDeleted={setIsDeleted}>
                <AnswerInfo />
            </AnswerList>
        </BodyContainer>
    );
};

export default Questions;
