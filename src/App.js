import React, {useState} from 'react';
import './App.css';

function App() {

    const [key, setKey] = useState("");

    function check() {
        alert("Das Password ist: " + key);
    }

    return (
        <div className="App">
            <h1>Check license key</h1>
            <div className="row-one">

                <div className="row-two">
                    <label htmlFor="key">Please enter your key: </label>
                    <br/>
                    <input
                        type="text"
                        id="key"
                        value={key}
                        onChange={(e) => setKey(e.target.value)}
                    />
                </div>

                <div className="row-three">
                    <button
                        className="button-check"
                        id="button-check"
                        onClick={check}>
                        Check
                    </button>
                </div>
            </div>
        </div>
    );
}

export default App;
