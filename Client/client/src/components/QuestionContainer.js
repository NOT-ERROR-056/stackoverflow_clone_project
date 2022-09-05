import React, { useState } from 'react';
import styled from 'styled-components';
import QuestionList from './QuestionList';

const Wrapper = styled.div`
    display: flex;
    justify-content: center;
    margin: 20px 10px;
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

const QuestionContainer = () => {
    const [pageNum, setPageNum] = useState(1);
    const getNum = (e) => {
        setPageNum(Number(e.target.textContent));
    };
    const pageArr = [1, 2, 3, 4, 5];
    //const pageArr = [];

    return (
        <>
            <QuestionList pageNum={pageNum}></QuestionList>
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
                    ...
                    <div>
                        <PageBtnOth>1529131</PageBtnOth>
                        <PageBtnOth>next</PageBtnOth>
                    </div>
                </Wrapper>
            ) : null}
        </>
    );
};

export default QuestionContainer;
