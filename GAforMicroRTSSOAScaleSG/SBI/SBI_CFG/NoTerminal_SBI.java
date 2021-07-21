package SBI_CFG;

import CFG.NoTerminal;
import LS_CFG.Node_LS;

public interface NoTerminal_SBI extends NoTerminal {
	Node_LS sorteiaFilho(int budget);
}
