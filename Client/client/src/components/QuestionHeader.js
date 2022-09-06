import React, { useState } from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';

const Wrapper = styled.div`
    display: flex;
    justify-content: space-between;
    margin-bottom: 10px;
    padding-bottom: 10px;
    > span.question-title {
        font-size: 1.8rem;
    }
    &:first-child {
        padding-top: 26px;
    }
`;

const Button = styled.button`
    background-color: white;
    color: black;
    box-shadow: inset 0 1px 0 0 hsl(0deg 0% 100% / 40%);
    border: 1px;
    border-radius: 3px;
    padding: 10.4px;
    cursor: pointer;
`;

const BlueButton = styled(Button)`
    background-color: #0a95ff;
    color: white;
    &:hover {
        background: #0074cc;
    }
`;

const SortButton = styled(Button)`
    background-color: #f8f9f9;
    color: black;
    border: 1px solid lightgray;
    &:hover {
        background: #e3e6e8;
    }
`;

const FilerButton = styled(Button)`
    background-color: rgb(208, 227, 239);
    color: #2c5877;
    border: 1px solid gray;
    &:hover {
        background: #b3d3ea;
    }
`;

const QuestionHeader = () => {
    const [totalNum, setTotalNum] = useState(0);

    fetch(`${process.env.REACT_APP_SERVER}/questions`)
        .then((res) => {
            return res.json();
        })
        .then((data) => {
            setTotalNum(data.pageInfo.totalElements);
        });
    return (
        <>
            <Wrapper>
                <span className="question-title">All Questions</span>

                <div>
                    <Link to="/questions/ask">
                        <BlueButton>Ask Question</BlueButton>
                    </Link>
                </div>
            </Wrapper>
            <Wrapper>
                <span>{totalNum} questions</span>
                <div>
                    <SortButton>Newest</SortButton>
                    <SortButton>Active</SortButton>
                    <SortButton>Bountied</SortButton>
                    <SortButton>Unanswered</SortButton>
                    <SortButton>Frequent</SortButton>
                    <SortButton>Score</SortButton>
                </div>
                <div>
                    <FilerButton>Filter</FilerButton>
                </div>
            </Wrapper>
        </>
    );
};

export default QuestionHeader;
