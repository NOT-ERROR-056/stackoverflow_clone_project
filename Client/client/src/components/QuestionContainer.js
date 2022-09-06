import React, { useState } from 'react';
import styled from 'styled-components';
import QuestionList from './QuestionList';

const Wrapper = styled.div`
    display: flex;
    justify-content: center;
    margin: 45px 10px;
`;

const PageBtnFirst = styled.span`
    background-color: hsl(27, 90%, 55%);
    color: white;
    margin-left: 3px;
    margin-right: 3px;
    margin-bottom: 10px;
    border: 1px;
    padding: 2px 8px;
    border-radius: 3px;
    cursor: pointer;
`;
const PageBtnOth = styled.span`
    background-color: transparent;
    border: 1px solid black;
    margin-left: 3px;
    margin-right: 3px;
    margin-bottom: 10px;
    border: 1px;
    padding: 2px 8px;
    border-radius: 3px;
    border: 1px solid lightgray;
    cursor: pointer;
    &:hover {
        background: lightgray;
    }
`;

const QuestionContainer = ({ setUserInfo }) => {
    const [pageNum, setPageNum] = useState(1);
    const [pageArr, setPageArr] = useState([]);

    const getNum = (e) => {
        setPageNum(Number(e.target.textContent));
    };

    return (
        <>
            <QuestionList pageNum={pageNum} setPageArr={setPageArr} setUserInfo={setUserInfo}></QuestionList>
            {pageArr.length !== 0 ? (
                <Wrapper>
                    {' '}
                    {pageArr.map((num, i) => {
                        return (
                            <div key={i}>
                                {pageNum === num ? (
                                    <PageBtnFirst onClick={getNum}>{num}</PageBtnFirst>
                                ) : (
                                    <PageBtnOth onClick={getNum}>{num}</PageBtnOth>
                                )}
                            </div>
                        );
                    })}
                </Wrapper>
            ) : null}
        </>
    );
};

export default QuestionContainer;
