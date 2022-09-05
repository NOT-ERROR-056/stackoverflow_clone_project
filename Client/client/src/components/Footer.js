import React from 'react';
import styled from 'styled-components';

const Styledfooter = styled.footer`
    background-color: hsl(210, 8%, 15%);
    background-position: top left;
    background-repeat: no-repeat;
    border-top: 0;
    background-size: auto;
    color: hsl(210, 8%, 60%);
    padding-top: 0;
    padding-bottom: 0;
    display: block;

    & a,
    a:visited,
    a:active,
    a:focus {
        text-decoration: none;
        color: hsl(210, 8%, 60%);
    }

    & > div {
        width: 78rem;
        max-width: 100%;
        margin: 0 auto;
        padding: 32px 12px 12px 12px;
        display: flex;
        flex-flow: row wrap;

        & > div:first-child {
            margin-right: 40px;
            & > a > svg {
                width: 32px;
                height: 37px;
            }
        }
        & > nav {
            display: flex;
            /* margin-right: 40px; */

            & > div {
                margin-right: 100px;

                & > h5 {
                    margin: 0;
                }

                & > ul {
                    list-style: none;
                    padding: 0;

                    & > li {
                        font-size: 13px;
                        margin-bottom: 8px;
                    }
                }
            }
        }
        & > div:last-child {
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            font-size: 8px;
            flex: 1 1 150px;

            & > ul {
                padding-left: 0;
                list-style: none;
                display: flex;
                margin-top: 0;

                & > li {
                    margin-right: 8px;
                }
            }
        }
    }
`;

const Footer = () => {
    return (
        <Styledfooter>
            <div>
                <div>
                    <a href="#!">
                        <svg xmlns="http://www.w3.org/2000/svg" width="110" height="124" viewBox="0 0 110 124">
                            <g fill="none" fillRule="evenodd">
                                <polygon fill="#BBBBBB" points="88 80 99 80 99 124 0 124 0 80 11 80 11 113 88 113" />
                                <path
                                    fill="#F58025"
                                    fillRule="nonzero"
                                    d="M22.9878906,76.73 L77.0128906,88.085 L79.2838906,77.285 L25.2588906,65.925 L22.9878906,76.73 Z M30.1368906,50.861 L80.1828906,74.169 L84.8448906,64.16 L34.7978906,40.852 L30.1368906,50.861 Z M43.9848906,26.308 L86.4128906,61.639 L93.4788906,53.154 L51.0508906,17.824 L43.9848906,26.308 Z M71.3718906,0.192 L62.5118906,6.782 L95.4598906,51.082 L104.319891,44.493 L71.3718906,0.192 Z M22,102 L77,102 L77,91 L22,91 L22,102 Z"
                                />
                            </g>
                        </svg>
                    </a>
                </div>
                <nav>
                    <div>
                        <h5>STACK OVERFLOW</h5>
                        <ul>
                            <li>Questions</li>
                            <li>Help</li>
                        </ul>
                    </div>
                    <div>
                        <h5>STACK OVERFLOW</h5>
                        <ul>
                            <li>Teams</li>
                            <li>Advertising</li>
                            <li>Collectives</li>
                            <li>Talent</li>
                        </ul>
                    </div>
                    <div>
                        <h5>TEAMMATES</h5>
                        <ul>
                            <li>
                                <a href="https://github.com/Si-Hyeak-KANG">강시혁</a>
                            </li>
                            <li>
                                <a href="https://github.com/NR0617">오나래</a>
                            </li>
                            <li>
                                <a href="https://github.com/HYUNSUK331">이현석</a>
                            </li>
                            <li>
                                <a href="https://github.com/git-daun">정다운</a>
                            </li>
                            <li>
                                <a href="https://github.com/hongmj37">홍민정</a>
                            </li>
                            <li>
                                <a href="https://github.com/Hong-sk">홍성권</a>
                            </li>
                            <li>
                                <a href="https://github.com/YunJuniverse">황윤준</a>
                            </li>
                        </ul>
                    </div>
                    <div>
                        <h5>STACK EXCHANGE NETWORK</h5>
                        <ul>
                            <li>dummy1</li>
                            <li>dummy2</li>
                            <li>dummy3</li>
                        </ul>
                    </div>
                </nav>
                <div>
                    <ul>
                        <li>
                            <a href="#!">Blog</a>
                        </li>
                        <li>
                            <a href="#!">Twitter</a>
                        </li>
                        <li>
                            <a href="#!">Facebook</a>
                        </li>
                        <li>
                            <a href="#!">Linkedin</a>
                        </li>
                        <li>
                            <a href="#!">Instagram</a>
                        </li>
                    </ul>
                    <p>저작권 표시표시 받아랏! 이잉 남은 칸 공백을 채우기fffffffffffffffffffffffffffffffffff</p>
                </div>
            </div>
        </Styledfooter>
    );
};

export default Footer;
