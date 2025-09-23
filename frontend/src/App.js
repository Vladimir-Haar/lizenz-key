import React, {useState} from 'react';
import './App.css';

function App() {
    const _apiBase = "http://localhost:8080/api/lizenz/pruefen";
    const [key, setKey] = useState("");
    const [message, setMessage] = useState("");

    function check() {
        fetch(_apiBase, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({lizenzschluessel: key})
        })
            .then(res => {
                if (!res.ok) throw new Error("Serverfehler");
                return res.json();
            })
            .then(data => {
                setMessage(data.message);
                setMessage(data.meldung);
                console.log(message);
            })
            .catch(err => setMessage("Fehler beim Prüfen!"));
    }

    function clear() {
        setKey("");
        setMessage("");
    }

    return (
        <div className="App">
            <h1>Prüfung des Schlüssels</h1>
            <div className="row-one">

                <div className="row-two">
                    <label htmlFor="key">Bitte Lizenzschlüssel eingeben: </label>
                    <br/>
                    <input
                        type="text"
                        id="key"
                        value={key}
                        onChange={(e) => setKey(e.target.value)}
                    />
                </div>

                <div className="output">
                    <p id="output">{message}</p>
                </div>

                <div className="buttons">
                    <div className="row-three">
                        <button
                            className="button-clear"
                            id="button-clear"
                            onClick={clear}>
                            Leeren
                        </button>
                    </div>

                    <div className="row-three">
                        <button
                            className="button-check"
                            id="button-check"
                            onClick={check}>
                            Prüfen
                        </button>
                    </div>
                </div>

            </div>
        </div>
    );
}

export default App;
