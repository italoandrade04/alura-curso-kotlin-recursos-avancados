package br.com.alura.forum.controller

import br.com.alura.forum.service.TopicoService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/relatorios")
@SecurityRequirement(name = "bearerAuth")
class RelatorioController(
    private val topicoService: TopicoService
) {

    @GetMapping
    fun relatorio(model: Model): String {
        model.addAttribute("topicosPorCategorias", topicoService.relatorio())
        return "relatorio"
    }
}