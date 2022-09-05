import React, { useState } from 'react';
import styled from 'styled-components';

const AnswerContainer = styled.div`
    display: flex;
`;
const Buttons = styled.div`
    margin-left: 3px;
`;
const AnswerRightBtn = styled.span`
    color: gray;
`;
const AnswerLeftBtn = styled.span`
    color: gray;
    margin-right: 10px;
`;

const HitnumBtns = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    flex-basis: 10%;
`;
const AnswerRecommendBox = styled.div`
    text-align: center;
    margin: 0;
    padding: 4px;
`;
const AnswerContentContainer = styled.div`
    border-bottom: 1px solid darkgray;
    padding: 10px;
    flex-basis: 90%;
    display: flex;
    flex-direction: column;
`;
const AnswerContent = styled.p`
    margin: 0;
`;
const AnswerBtnContainer = styled.div`
    display: flex;
    justify-content: space-between;
`;
const AnswerInfoTag = styled.div`
    /* border: 1px solid lightgray; */
    display: flex;
    flex-direction: column;
    font-size: 0.7rem;
`;
const AnswerUserId = styled.p`
    color: blue;
    margin: 0;
    font-size: 1rem;
`;
const AnsweredDate = styled.p`
    color: gray;
    margin: 0;
`;
const AnswerInput = styled.textarea`
    margin-bottom: 10px;
    border: ${({ alert }) => (alert ? '2px solid blue' : null)};
    border-radius: ${({ alert }) => (alert ? '3px' : null)};
    box-shadow: ${({ alert }) => (alert ? '0px 0px 5px blue' : null)};
    outline-color: ${({ alert }) => (alert ? 'blue' : null)};
    resize: none;
`;

const AnswerInfo = ({ answerId, userId, content, regDate, editDate, recommendNum, questionId, setIsLoading }) => {
    const url = 'http://192.168.4.143:8080';
    const deleteAnswer = () => {
        fetch(`${url}/questions/${questionId}/answers/${answerId}`, {
            method: 'DELETE',
        }).then(() => window.location.reload());
    };
    const [isEdit, setIsEdit] = useState(false);
    const editAnswer = () => {
        setIsEdit(true);
    };

    const [editedAnswer, setEditedAnswer] = useState('');
    const answerEdit = (e) => {
        setEditedAnswer(e.target.value.trim());
    };
    const answer = {
        content: editedAnswer,
    };
    const [alert, setAlert] = useState(false);
    const sendEditAnswer = () => {
        if (editedAnswer.trim().length === 0) {
            setAlert(true);
            return;
        }
        fetch(`${url}/questions/${questionId}/answers/${answerId}`, {
            method: 'PATCH',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(answer),
        })
            .then(() => {
                setIsLoading(true);
                setIsEdit(false);
                setAlert(false);
                window.location.reload();
            })
            .then(() => setIsLoading(false));
    };
    const cancelBtn = () => {
        setIsEdit(false);
        setAlert(false);
    };
    return (
        <AnswerContainer>
            <HitnumBtns>
                <svg
                    aria-hidden="true"
                    className="svg-icon iconArrowUpLg"
                    width="36"
                    height="36"
                    viewBox="0 0 36 36"
                    style={{ fill: 'rgb(186, 191, 195)' }}
                >
                    <path d="M2 25h32L18 9 2 25Z"></path>
                </svg>
                <AnswerRecommendBox>{recommendNum}</AnswerRecommendBox>
                <svg
                    aria-hidden="true"
                    className="svg-icon iconArrowDownLg"
                    width="30"
                    height="30"
                    viewBox="0 0 36 36"
                    style={{ fill: 'rgb(186, 191, 195)' }}
                >
                    <path d="M2 11h32L18 27 2 11Z" />
                </svg>
            </HitnumBtns>
            <AnswerContentContainer>
                {isEdit ? (
                    <AnswerInput type="text" defaultValue={content} onChange={answerEdit} alert={alert} />
                ) : (
                    <AnswerContent>{content}</AnswerContent>
                )}
                {alert && <span style={{ color: 'blue' }}>댓글을 입력하세요</span>}
                <AnswerBtnContainer>
                    <Buttons>
                        {isEdit ? (
                            <>
                                <AnswerLeftBtn onClick={sendEditAnswer}>Send</AnswerLeftBtn>
                                <AnswerRightBtn onClick={cancelBtn}>Cancel</AnswerRightBtn>
                            </>
                        ) : (
                            <>
                                <AnswerLeftBtn onClick={editAnswer}>Edit</AnswerLeftBtn>
                                <AnswerRightBtn onClick={deleteAnswer}>Delete</AnswerRightBtn>
                            </>
                        )}
                    </Buttons>
                    <AnswerInfoTag>
                        <AnswerUserId>{userId}</AnswerUserId>
                        <AnsweredDate>{editDate}</AnsweredDate>
                    </AnswerInfoTag>
                </AnswerBtnContainer>
            </AnswerContentContainer>
        </AnswerContainer>
    );
};

export default AnswerInfo;
