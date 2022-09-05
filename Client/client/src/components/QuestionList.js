import React, { useEffect, useState } from 'react';
import EmptyPage from './EmptyPage';
import Question from './Question';

const QuestionList = ({ pageNum }) => {
    const [question, setQuestion] = useState([]);

    const getData = async (url) => {
        let response = await fetch(url);
        let data = await response.json();
        // setQuestion(data.data);
        
        setQuestion(data.data);
    };

    useEffect(() => {
        getData(`http://192.168.4.143:8080/questions?page=${Number(pageNum)}&size=3`);
    }, [pageNum]);

    return (
        <>{question.length !== 0 ? question.map((item) => <Question item={item} key={item.id} />) : <EmptyPage />}</>
    );
};

export default QuestionList;
