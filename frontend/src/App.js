import React, { useEffect, useState } from "react";
import "./App.css";

function App() {
  const _apiBase = "http://localhost:8080/api/lizenz/pruefen";
  const [key, setKey] = useState("");
  const [message, setMessage] = useState("");
  const [farbe, setFarbe] = useState("white");
  const [isGueltig, setGueltig] = useState(false);
  const [hasKey, setHasKey] = useState(false);

  function probe() {
    if (!hasKey) setFarbe("white");
    // <- Solange kein Schlüssel eingegeben wurde bzw. der Nutzer nicht auf "Prüfen" klickt
    else setFarbe(isGueltig ? "green" : "red"); // Wird gerade ein Schlüssel geprüft: Gültigkeit auswerten
  }

  useEffect(() => {
    probe();
  }, [isGueltig, hasKey, probe]);

  function check() {
    fetch(_apiBase, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ lizenzschluessel: key }),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Serverfehler");
        return res.json();
      })
      .then((data) => {
        setHasKey(true);
        setMessage(data.meldung);
        setGueltig(data.gueltig);
      })
      .catch((err) => {
        setMessage("Fehler beim Prüfen!");
        setGueltig(false);
      });
  }

  function clear() {
    setKey("");
    setMessage("");
    setGueltig(false);
    setHasKey(false);
    setFarbe("white");
  }

  return (
    <div className="App">
      <div className="row-one" style={{ border: `3px solid ${farbe}` }}>
        <h1>Prüfung des Schlüssels</h1>
        <div className="row-two">
          <label htmlFor="key">Bitte Lizenzschlüssel eingeben: </label>
          <br />
          <input
            type="text"
            id="key"
            value={key}
            onChange={(e) => setKey(e.target.value)}
          />
        </div>

        <div className="output">
          <p id="output">{message.meldung}</p>
        </div>

        <div className="buttons">
          <div className="row-three">
            <button className="button-clear" id="button-clear" onClick={clear}>
              Leeren
            </button>
          </div>

          <div className="row-three">
            <button className="button-check" id="button-check" onClick={check}>
              Prüfen
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
