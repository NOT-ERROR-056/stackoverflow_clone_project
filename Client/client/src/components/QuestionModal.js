import React from 'react';
import styled from 'styled-components';

const ModalContainer = styled.div`
    /* height: 15rem;
    text-align: center;
    margin: 120px auto; */
`;
const ModalBackdrop = styled.div`
    position: fixed;
    z-index: 999;
    top: 0;
    left: 0;
    bottom: 0;
    right: 0;
    background-color: rgba(0, 0, 0, 0.4);
    display: grid;
    place-items: center;
`;
const ModalView = styled.span`
    width: 400px;
    height: 350px;
    background-color: white;
    border-radius: 10px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
`;
const ModalMsg = styled.p`
    margin-bottom: 1.5em;
    font-size: 1.5em;
`;
const ModalDeleteBtn = styled.span`
    width: fit-content;
    height: fit-content;
    padding: 10px;
    text-align: center;
    background-color: blue;
    color: white;
    border-radius: 5px;
    /* font-weight: medium; */
    font-size: large;
`;

const QuestionModal = ({ deleteQuestion, setIsOpen }) => {
    const closeModal = () => {
        setIsOpen(false);
    };

    return (
        <ModalContainer>
            <ModalBackdrop onClick={closeModal}>
                <ModalView>
                    <ModalMsg>삭제하시겠습니까?</ModalMsg>
                    <ModalDeleteBtn onClick={deleteQuestion}>삭제하기</ModalDeleteBtn>
                </ModalView>
            </ModalBackdrop>
        </ModalContainer>
    );
};

export default QuestionModal;
