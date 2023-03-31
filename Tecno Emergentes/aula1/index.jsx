const root = window.document.getElementById("root");

function Participante(props) {
    // var votos = 0;
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
            <Participante nome="Ban david"/ >
            <Participante nome="Ban Felix"/ >
        </div> 
    )
}


ReactDOM.createRoot(root).render(
    <Votacao />
);