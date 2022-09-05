import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import AnswerInfo from './AnswerInfo';
import Reply from '../components/Reply';

const AnswerListContainer = styled.div`
    display: flex;
    flex-direction: column;
    border-top: 1px solid darkgray;
`;

const AnswerList = ({ questionId, isDeleted, setIsDeleted }) => {
    const [isLoading, setIsLoading] = useState(true);
    const url = 'http://192.168.4.143:8080';
    const [answers, setAnswers] = useState([]);

    useEffect(() => {
        const getAnswer = async () => {
            const data = await fetch(`${url}/questions/${questionId}/answers`).then((res) => res.json());

            setAnswers(data.data);
            setIsLoading(false);
        };
        getAnswer();
    }, []);

    const deletedAnswer = (answerId) => {
        fetch(`${url}/questions/${questionId}/answers/${answerId}`, {
            method: 'DELETE',
        });
    };
    if (isDeleted) {
        answers.map((el) => {
            return deletedAnswer(el.answerId);
        });
        setIsDeleted(false);
    }

    return (
        <>
            {isLoading ? (
                <p>Loading...</p>
            ) : (
                <AnswerListContainer>
                    {answers.map((el) => {
                        return (
                            <AnswerInfo
                                key={el.answerId}
                                answerId={el.answerId}
                                userId="돌고래"
                                content={el.content}
                                regDate={el.regDate}
                                editDate={el.editDate}
                                recommendNum={el.recommendNum}
                                questionId={el.questionId}
                                setIsLoading={setIsLoading}
                            />
                        );
                    })}
                </AnswerListContainer>
            )}
            <Reply questionId={questionId} />
        </>
    );
};
export default AnswerList;
