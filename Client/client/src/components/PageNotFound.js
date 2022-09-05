import styled from 'styled-components';
import { BodyContainer } from './BodyContainer';

const ErrorPageWrapper = styled.div`
    width: 60vw;
    height: 56vh;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    > p {
        font-size: 2em;
    }
    span {
        font-size: 1.5em;
        display: flex;
        flex-direction: column;
    }
    > span :first-child {
        font-size: 1rem;
        color: white;
        text-align: center;
    }
`;
const PageNotFound = () => {
    return (
        <BodyContainer>
            <ErrorPageWrapper>
                <h1>죄송합니다. 요청하신 페이지를 찾을 수 없습니다</h1>
                <p>페이지가 삭제되었거나 없는 페이지입니다.</p>
                <span>
                    다른 페이지를 요청하거나 help로 문의해주세요.<p>화이팅</p>
                </span>
            </ErrorPageWrapper>
        </BodyContainer>
    );
};

export default PageNotFound;
