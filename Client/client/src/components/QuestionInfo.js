import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import QuestionModal from './QuestionModal';
import { useNavigate } from 'react-router-dom';

const QuestionInfoContainer = styled.div`
    padding-top: 26px;
    display: flex;
    flex-direction: column;
    padding-top: 25px;
`;
const QuestionRecommendBox = styled.div`
    text-align: center;
    margin: 0;
    padding: 4px;
`;
const HitnumBtns = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    flex-basis: 10%;
`;
const QuestionInfoContent = styled.div`
    overflow: hidden;
    display: flex;
`;
const QuestionTitle = styled.div`
    border-bottom: 1px solid darkgray;
    display: flex;
`;
const TitleInfo = styled.div`
    display: flex;
    flex-direction: column;
    margin: 0 10px 10px 0;
    flex-basis: 80%;
`;
const TitleContent = styled.h1`
    margin: 0;
    font-weight: normal;
`;
const TitleViewed = styled.p`
    margin: 15px 0 0 0;
    color: #6a737c;
`;

const QuestionContent = styled.div`
    padding: 10px;
    margin: 20px 0 20px 0;
`;

const ButtonContainer = styled.div`
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    margin-bottom: 10px;
`;
const QuestionContainer = styled.div`
    flex-basis: 90%;
`;
const QuestionTag = styled.p`
    margin: 0 3px 20px 3px;
    width: fit-content;
    background-color: skyblue;
    color: blue;
    border-radius: 3px;
    padding: 2px;
`;
const Buttons = styled.div`
    margin-left: 3px;
`;
const EditButton = styled.span`
    color: gray;
    margin-right: 10px;
`;
const DeleteButton = styled.span`
    color: gray;
`;
const QuestionUserId = styled.div`
    color: blue;
    border-radius: 3px;
    padding: 8px;
    background-color: #d9e9f7;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
`;
const RecommendPlusBtn = styled.button`
    border: none;
    padding: 0;
    background-color: transparent;
    cursor: default;
    background-image: url('https://cdn.sstatic.net/Img/unified/sprites.svg?v=fcc0ea44ba27');
    background-position: -4px -170px;
    width: 30px;
    height: 30px;
`;

const RecommendMinusBtn = styled.button`
    border: none;
    padding: 0;
    background-color: transparent;
    cursor: default;
    background-image: url('https://cdn.sstatic.net/Img/unified/sprites.svg?v=fcc0ea44ba27');
    background-position: -4px -220px;
    width: 30px;
    height: 30px;
`;

const QuestionInfo = ({ questionId, setIsDeleted, setUserInfo }) => {
    const url = 'http://192.168.4.143:8080';
    const [isLoading, setIsLoading] = useState(true);
    const navigate = useNavigate();
    const [question, setQuestion] = useState({});
    const [isOpen, setIsOpen] = useState(false);
    const openModal = () => {
        setIsOpen(true);
    };
    const deleteQuestion = () => {
        fetch(`${url}/questions/${questionId}`, {
            method: 'DELETE',
        }).then(() => {
            setIsLoading(true);
            setIsDeleted(true);
            window.location.replace('/');
            setIsLoading(false);
        });
    };

    useEffect(() => {
        const questions = async () => {
            const ques = await fetch(`${url}/questions/${questionId}`).then((res) => {
                if (res.status === 404) {
                    navigate('/notfound');
                } else {
                    return res;
                }
            });
            const data = await ques.json();
            console.log(data);
            setUserInfo(data.data);
            setQuestion(data.data);
            setIsLoading(false);
        };
        questions();
    }, []);

    const navigateToEditPage = () => {
        navigate(`/questions/ask/${questionId}`);
    };

    return (
        <QuestionInfoContainer>
            {isLoading ? (
                <p>Loading...</p>
            ) : (
                <>
                    <QuestionTitle>
                        <TitleInfo>
                            <TitleContent>{question['title']}</TitleContent>
                            <TitleViewed>viewed {question['viewNum']} times</TitleViewed>
                        </TitleInfo>
                    </QuestionTitle>
                    <QuestionInfoContent>
                        <HitnumBtns>
                            <RecommendPlusBtn />
                            <QuestionRecommendBox>{question['recommendNum']}</QuestionRecommendBox>
                            <RecommendMinusBtn />
                            <svg
                                aria-hidden="true"
                                className="svg-icon iconBookmark"
                                width="30"
                                height="40"
                                viewBox="0 -5 20 30"
                                style={{ fill: 'rgb(186, 191, 195)' }}
                            >
                                <path d="M6 1a2 2 0 0 0-2 2v14l5-4 5 4V3a2 2 0 0 0-2-2H6Zm3.9 3.83h2.9l-2.35 1.7.9 2.77L9 7.59l-2.35 1.7.9-2.76-2.35-1.7h2.9L9 2.06l.9 2.77Z"></path>
                            </svg>
                            <svg
                                aria-hidden="true"
                                className="mln2 mr0 svg-icon iconHistory"
                                width="30"
                                height="40"
                                viewBox="0 0 25 30"
                                style={{ fill: 'rgb(186, 191, 195)' }}
                            >
                                <path d="M3 9a8 8 0 1 1 3.73 6.77L8.2 14.3A6 6 0 1 0 5 9l3.01-.01-4 4-4-4h3L3 9Zm7-4h1.01L11 9.36l3.22 2.1-.6.93L10 10V5Z"></path>
                            </svg>
                        </HitnumBtns>
                        <QuestionContainer>
                            <QuestionContent>{question['content']}</QuestionContent>
                            <QuestionTag>태그자리</QuestionTag>
                            <ButtonContainer>
                                <Buttons>
                                    <EditButton onClick={navigateToEditPage}>Edit</EditButton>
                                    <DeleteButton onClick={openModal}>Delete</DeleteButton>
                                    {isOpen ? (
                                        <QuestionModal deleteQuestion={deleteQuestion} setIsOpen={setIsOpen} />
                                    ) : null}
                                </Buttons>
                                <QuestionUserId>{question['questionId']}</QuestionUserId>
                            </ButtonContainer>
                        </QuestionContainer>
                    </QuestionInfoContent>
                </>
            )}
        </QuestionInfoContainer>
    );
};

export default QuestionInfo;
