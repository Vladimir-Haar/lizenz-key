import React, {useState} from 'react';
import './App.css';

function App() {

    const [key, setKey] = useState("");

    function check() {
        if (key && key.trim() !== "") {
            alert("Das Password ist: " + key);
        } else {
            alert("Das Passwordfeld ist leer");
        }
    }

    function clear() {
        document.getElementById("key").value = "";
        setKey("");
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

                <div className="output">
                    <label
                        htmlFor="output"
                        id="output"
                        value={""}
                    ></label>
                </div>

                <div className="buttons">
                    <div className="row-three">
                        <button
                            className="button-clear"
                            id="button-clear"
                            onClick={clear}>
                            Clear
                        </button>
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
        </div>
    );
}

export default App;
