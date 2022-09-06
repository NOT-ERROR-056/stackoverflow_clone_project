import React, { useState } from 'react';
import styled from 'styled-components';

const ReplyContainer = styled.div`
    display: flex;
    flex-direction: column;
    height: 40%;
`;
const ReplyQuestion = styled.textarea`
    height: 400px;
    margin-bottom: 10px;
    border: ${({ alert }) => (alert ? '2px solid blue' : null)};
    border-radius: ${({ alert }) => (alert ? '5px' : null)};
    box-shadow: ${({ alert }) => (alert ? '0px 0px 5px blue' : null)};
    outline-color: ${({ alert }) => (alert ? 'blue' : null)};
    resize: none;
`;
const ReplyBtn = styled.span`
    width: fit-content;
    margin-top: 10px;
    background-color: #0995ff;
    color: white;
    padding: 8px;
    border-radius: 3px;
    overflow: hidden;
    &:hover {
        background-color: #0074cc;
    }
`;

const Reply = ({ questionId }) => {
    const url = process.env.REACT_APP_SERVER;

    const [content, setContent] = useState('');
    const createContent = (e) => {
        setContent(e.target.value.trim());
    };
    const [alert, setAlert] = useState(false);
    const reply = () => {
        if (content.trim().length === 0) {
            setAlert(true);
            return;
        }
        const data = {
            content,
        };
        fetch(`${url}/questions/${questionId}/answers`, {
            headers: { 'Content-Type': 'application/json' },
            method: 'POST',
            body: JSON.stringify(data),
        })
            .then((res) => res.json())
            .then((res) => window.location.replace(`/questions/${res.data.questionId}`));
        setAlert(false);
    };
    return (
        <ReplyContainer>
            <h3>Your Answer</h3>

            <ReplyQuestion onChange={createContent} alert={alert} />

            {alert && <span style={{ color: 'blue' }}>댓글을 입력하세요</span>}
            <ReplyBtn onClick={reply}>Post Your Answer</ReplyBtn>
        </ReplyContainer>
    );
};

export default Reply;
