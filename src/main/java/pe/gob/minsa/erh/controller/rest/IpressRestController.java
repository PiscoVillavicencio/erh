package pe.gob.minsa.erh.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.model.entity.IpressEntity;
import pe.gob.minsa.erh.service.IpressService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/ipresses")
public class IpressRestController {

    @Autowired
    private IpressService ipressService;

    @GetMapping(value = "/", produces = "application/json")
    public List<IpressEntity> getIpress() {

        return ipressService.listAll();
    }

}
