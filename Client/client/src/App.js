import './App.css';
import Home from './pages/Home';
import AskQuestion from './pages/AskQuestion';
import Questions from './pages/Questions';
import Header from './components/Header';
import Footer from './components/Footer';

import { Routes, Route, BrowserRouter as Router } from 'react-router-dom';
import PageNotFound from './components/PageNotFound';
import { useState } from 'react';

function App() {
    const [userInfo, setUserInfo] = useState({});
    return (
        <>
            <Header />
            <Router>
                <Routes>
                    <Route path="/" element={<Home setUserInfo={setUserInfo} />} />
                    <Route path="/questions/:id" element={<Questions setUserInfo={setUserInfo} />} />
                    <Route path="/notfound" element={<PageNotFound />} />
                    <Route path="/questions/ask" element={<AskQuestion userInfo={userInfo} />} />
                    <Route path="/questions/ask/:id" element={<AskQuestion userInfo={userInfo} />} />
                </Routes>
            </Router>
            <Footer />
        </>
    );
}

export default App;
