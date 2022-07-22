import React from 'react'
import { Link, useParams } from 'react-router-dom'
import { Row, Col, Image, ListGroup } from 'react-bootstrap';
import servicesData from '../servicesData'

function ServicesDetail() {
    const {id} = useParams()
    const {thisid} = servicesData.find(prod => prod.id === id)

    return (
        <div>
            <Link to='/' className='btn btn--primary'>Home</Link>
            <Row>
                <Col md={6}>
                    <Image src={thisid.src} alt={thisid.path} fluid />
                </Col>

                <Col md={6}>
                    <ListGroup variant="flush">
                        <ListGroup.Item>
                            <h3>{thisid.label}</h3>
                        </ListGroup.Item>

                        <ListGroup.Item>
                            Description: {thisid.text}
                        </ListGroup.Item>
                    </ListGroup>
                </Col>
            </Row>
        </div>
    )
}

export default ServicesDetail