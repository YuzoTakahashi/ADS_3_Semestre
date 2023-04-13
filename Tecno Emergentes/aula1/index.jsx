const root = window.document.getElementById("root");

function Participante(props) {
    const [votos, setVotos] = React.useState(0);

    function acrescentar() {
        setVotos(votos + 1);
        console.log("Votos: ", votos);
    }
    function reduzir() {
        setVotos(votos - 1)
        console.log("Votos: ", votos);
    }
    return (
        <div>
            <div>{ props.nome }</div>
            <div>Votos: {votos}</div>
            <button onClick={acrescentar}>+</button>
            <button onClick={reduzir}>-</button>
        </div>
    );
}

function Votacao() {
    return(
        <div>
            <Participante nome="Biscoito"/ >
            <Participante nome="Bolacha"/ >
        </div> 
    )
}


ReactDOM.createRoot(root).render(
    <Votacao />
);